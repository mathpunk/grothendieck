(ns grothendieck.front-matter
  (:require [clojure.string :as string])
  (:require [swiss.arrows :refer :all]))

(defn process-lines [lines]
  (let [ls (->> lines
                (map string/trim)
                (remove string/blank?))]
    (if (= (first ls) "---")
      (let [[front sep-and-body] (split-with #(not= "---" %) (next ls))]
        {:front (vec front) :body (vec (next sep-and-body))})
      {:body (vec ls)})))

(defn with-front-matter [f]
  (with-open [r (clojure.java.io/reader f)]
    (let [data (process-lines (line-seq r))
          front-mattered (assoc data :front
           (apply assoc {} (flatten
               (for [string (:front data)]
                  (let [split (clojure.string/split string #":")
                        k (keyword (first split))
                        v (rest split)]
                    (assert (= (count split) 2) "There might be a colon to handle in a front-matter field.")
                ;; For some reason, I get a string when I get-in after the fact,
                ;; but a ChunkedSeq if I try and do stuff here. So the next function up
                ;; is gonna have to deal with the whitespace. Suck it.
                       [k v])))))]
     (update-in front-mattered [:body] str))))




(let [testfile (clojure.java.io/file
                 "/home/thomas/hax0r/grothendieck/src/grothendieck/test/test-site/the first person with a head.wiki")
      data  (with-front-matter testfile)]
  (:body data))


