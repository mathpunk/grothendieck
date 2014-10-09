(ns leiningen.grot
  "This is supposed to be a sort of build tool for static sites. I haven't quite
  cracked the syntax for doing 'lein grot built foo bar' yet though."
  (:require [swiss.arrows :refer :all])
  (:require [grothendieck.static.front-matter :refer :all])
  (:require [grothendieck.static.html :refer [page-html slug]]))

;; =============================================================================
;; Preprocessing
;; =============================================================================
;; Read some configuration (currently cheating)
;; Get the text content files from the dir.
;; Helpful functions for making titles and filenames.

(defn config [dir]
  "Read an edn file called config.edn in the site's dir, or pick some defaults."
  {:sitename "finite.support"})

(defn files [dir]
  "Given a directory name, return the wiki and markdown files."
  (remove (fn [x] (empty?  (re-seq #"\.(md|wiki)" (.getName x))))
          (file-seq (clojure.java.io/file dir))))


;; ========================================================================================
;; Building
;; ========================================================================================
;; Okay cool. Now you've got your file processing methods, and you ought should be able to
;; use front-matter and everything. So how do you actually build a site?
;;
;; It should:
;; 1. Take a dir to look for text content.
;; 2. The dir should have a "target" dir to take the html.
;; 3? Check if it's marked, :publish? yes or true
;; 4. For each publishable file, use its preprocess into a map to make html.


;; ===========================================================================
;; I/0
;; ===========================================================================
(defn write-page [dir f]
  (spit (clojure.java.io/file dir "target" (slug (.getName f))) (page-html dir f)))

(defn build-pages [dir]
  (for [f (files dir)]
    (write-page dir f)))



;; =============================================================================
;; Testing
;; =============================================================================
;; I don't know how to write proper tests for html, so sleazytesting via stray
;; let statements that I evaluate in Lightable will have to do for now.

(let [dir "/home/thomas/hax0r/grothendieck/test/grothendieck/test-site/content"
      testfile (clojure.java.io/file dir "the first person with a head.wiki")
      othertestfile (clojure.java.io/file dir "title are cool.wiki")
      testnofront (clojure.java.io/file dir "backstaging.wiki")]
  (build-pages dir))












;; ===========================================================================
;; Here are some garbage notes on things that may or may not want to be written in bash.
;;
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
;;
;;
;; =============================================================================
;; Possible refactoring
;; =============================================================================
;; Use protocols?
;;(defrecord WikiDir [path]
;;  File
;;  ())
;;(let [testing "src/test/"])

