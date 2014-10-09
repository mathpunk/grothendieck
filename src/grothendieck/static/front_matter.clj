(ns grothendieck.static.front-matter
  (:require [swiss.arrows :refer :all]))

(defn process-lines [lines]
  (let [ls (->> lines
                (map clojure.string/trim)
                (remove clojure.string/blank?))]
    (if (= (first ls) "---")
      (let [[front sep-and-body] (split-with #(not= "---" %) (next ls))]
        {:front (vec front) :body (vec (next sep-and-body))})
      {:body (vec ls)})))

(defn process-file [f]
  (process-lines (line-seq (clojure.java.io/reader f))))

(defn front-matter [f]
    (let [data (update-in  (process-file f) [:body] clojure.string/join)]
      (if (:front data)
           (apply assoc {} (flatten
               (for [string (:front data)]
                  (let [split (clojure.string/split string #":")
                        k (keyword (first split))
                        v (rest split)]
                    (assert (= (count split) 2) "grothendieck.static.front-matter
                                                 might be confused by a colon in a field's value.")
                    [k (map #(clojure.string/trim %) v)]))))
        data)))

(defn with-front-matter [f]
  (let [data (process-file f)]
    (-<> data
         (assoc-in <> [:front] (front-matter f))
         (update-in <> [:body] #(clojure.string/join " " %)))))


;; (defn with-front-matter [f]
;;   (with-open [r (clojure.java.io/reader f)]
;;     (let [data (update-in (process-lines (line-seq r)) [:body] clojure.string/join)]
;;       (if (:front data)
;;            (apply assoc {} (flatten
;;                (for [string (:front data)]
;;                   (let [split (clojure.string/split string #":")
;;                         k (keyword (first split))
;;                         v (rest split)]
;;                     (assert (= (count split) 2) "grothendieck.static.front-matter
;;                                                  might be confused by a colon in a field's value.")
;;                     [k (map #(string/trim %) v)]))))
;;         data))))

(let [test "/home/thomas/hax0r/grothendieck/test/grothendieck/test-site/content/title are cool.wiki"]
  (with-front-matter test))
