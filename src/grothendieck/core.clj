(ns grothendieck.core
  (:require [grothendieck.pages :refer [make-page]])
  (:require [swiss.arrows :refer :all])
  ;(:require [grothendieck.front-matter :refer :all])
  ;(:gen-class :main true)
  )

;(defrecord WikiDir [path]
;  File
;  ())
;(let [testing "src/test/"])

(defn files [dir]
  (remove (fn [x] (empty?  (re-seq #"\.(md|wiki)" (.getName x))))
          (file-seq (clojure.java.io/file dir))))

; def pages

(defn preprocessed [file]
  {:title (.getName file) :body (slurp file)}
  )

(defn slug [filename]
  (-<> filename
      (clojure.string/lower-case)
      (clojure.string/replace <> " " "-")))

(defn write-page [target title]
  (fn [f]
    (let [filename (slug (.getName f))
          path (java.io.File. target filename)]
       (spit path (make-page {:title title :keywords "" :body (slurp f)})))))

(defn build-site [title source target]
  (println "Building site " title " from the " source " directory..................")
  (let [please-to-write (write-page target title)]
    (map #(please-to-write %) (files source)))
  (println "Built " source "site in " target "."))



;(defn -main [title source target]

;; bash looks to see if anything important has changed.

;; future: clj, read the headers if any
;;   publishable?
;;   :title
;;   :keywords
;;   :slug
;;   :site
;;   :category
;; and
;;   :body

;; take the file's contents,
;; give them to chapter/page
;; spit the result to target.
