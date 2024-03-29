(ns grothendieck.front-matter
  (:require [swiss.arrows :refer :all]))

(defn process-lines [lines]
  "This helper function turns lines into a not-quite-shaped-right :front :body associative structure."
  (let [ls (->> lines
                (map clojure.string/trim)
                (remove clojure.string/blank?))]
    (if (= (first ls) "---")
      (let [[front sep-and-body] (split-with #(not= "---" %) (next ls))]
        {:front (vec front) :body (vec (next sep-and-body))})
      {:body (vec ls)})))

(defn process-file [f]
  "Opens the filename and runs it through the line processor. It's still not shaped quite right."
  (process-lines (line-seq (clojure.java.io/reader f))))

(defn front-matter [f]
  "Takes a filename, and extracts its front-matter, if there is any."
    (let [data (update-in (process-file f) [:body] clojure.string/join)]
      (if (:front data)
           (apply assoc {} (flatten
               (for [string (:front data)]
                  (let [split (clojure.string/split string #":")
                        k (keyword (first split))
                        v (rest split)]
                    (assert (= (count split) 2) "grothendieck.static.front-matter
                                                 might be confused by a colon in a field's value.")
                    [k (map #(clojure.string/trim %) v)]))))
        {})))

(defn with-front-matter [f]
  "Given some text file, "
  (let [data (process-file f)]
    (-<> data
         (assoc-in <> [:front] (front-matter f))
         (update-in <> [:body] #(clojure.string/join "\n" %)))))

(let [test "/home/thomas/hax0r/grothendieck/test/grothendieck/test-site/content/title are cool.wiki"]
  (with-front-matter test))
