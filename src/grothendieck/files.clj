(ns grothendieck.files
  (:require [grothendieck.front-matter :refer [with-front-matter]])
  (:require [swiss.arrows :refer :all]))

;; ===================================================================
;; making nice filename slugs out of title-like terms
;; ===================================================================
(defn title->slug
  ([f]
   "Normalizes titles into link-friendly titles. Standardizes file extension."
    (-<> f
        (clojure.string/lower-case)
        (clojure.string/replace <> " " "-") ; dehyphenation
        (clojure.string/replace <> #"\.(wiki|md|my)" ".html"))))
  ;; slug use cases
  ;; (try
  ;;   (title->slug (get-in text [:front :title]))
  ;; (try
  ;;   (title->slug (.getName (:file text)))
  ;; (try
  ;;   "untitled"
  ;; (throw "something horrible is happening, like a filename collision")


;; ===================================================================
;; collect the content text files, with or without headers
;; ===================================================================
(defn files [dir]
  "Given a directory name, return the wiki and markdown and custom nanoformat files."
  (remove (fn [x] (empty?  (re-seq #"\.(md|wiki|my)" (.getName x))))
          (file-seq (clojure.java.io/file dir))))
