(ns grothendieck.core
  (:require [grothendieck.page :refer :all])
  (:gen-class :main true))

(defn md-file->page [f]
  (let [title (:title f) content (slurp f)]
    (page (assoc {} title content))))

(defn -main [source target]
  (println "Building site.......")
  (spit target (md-file->page source))
  (println "Site built!"))


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
