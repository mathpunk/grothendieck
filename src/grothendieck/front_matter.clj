(ns grothendieck.front-matter
  (:require [clojure.string :as string]))

(defn- process-lines [lines]
  (let [ls (->> lines
                (map string/trim)
                (remove string/blank?))]
    (if (= (first ls) "---")
      (let [[front sep-and-body] (split-with #(not= "---" %) (next ls))]
        {:front (vec front) :body (vec (next sep-and-body))})
      {:body (vec ls)})))

(defn with-front-matter [f]
  (with-open [r (clojure.java.io/reader f)]
    (process-lines (line-seq r))))
