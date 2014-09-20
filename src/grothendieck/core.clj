(ns grothendieck.core
  (:require [grothendieck.pages :refer [make-page]])
  (:require [swiss.arrows :refer :all])
  (:require [grothendieck.front-matter :refer :all])
  ;(:gen-class :main true)
  )

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

(defn slug [filename]
  "Replaces nasty spaces with friendly hyphens. Maybe it should cut off file extensions..."
  (-<> filename
      (clojure.string/lower-case)
      (clojure.string/replace <> " " "-")))

(defn title [dir f]
  "If there's a title in the front-matter, use that.
  Otherwise, create a title out of the filename."
  (let [prefix (str (:sitename (config dir)) " | ")]
    (if-let [title (get-in (with-front-matter f) [:front :title])]
      (str prefix title)
      (str prefix
       (-<> f
           (.getName <>)
           (clojure.string/split <> #"\.")
           (first <>))))))

;; ========================================================================================
;; Building
;; ========================================================================================
;; Okay cool. Now you've got your file processing methods, and you ought should be able to
;; use front-matter and everything. So how do you actually build a site?
;;
;; It should:
;; 1. Take a dir to look for text content. 
;; 2. Either take a dir, or assume that it's the dir+"html" or "target" or whatever.
;; 3? Check if it's marked, :publish? yes or true
;; 4. For each publishable file, use its preprocess into a map to make html.
;;
;; ----------------------------------------------------------------------------- 
;; Here is some garbage code:
;;
;; (defn write-page [target title]
;;   (fn [f]
;;     (let [filename (slug (.getName f))
;;           path (java.io.File. target filename)]
;;        (spit path (make-page {:title title :keywords "" :body (slurp f)})))))
;;
;; (defn build-site [title source target]
;;   (println "Building site " title " from the " source " directory..................")
;;   (let [please-to-write (write-page target title)]
;;     (map #(please-to-write %) (files source)))
;;   (println "Built " source "site in " target "."))
;;
;;(defn -main [title source target]
;;
;; ----------------------------------------------------------------------------- 
;;
;; And here are some garbage notes on things that may or may not want to be written in bash. 
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
;; ----------------------------------------------------------------------------- 





;; ============================================================================= 
;; Testing
;; ============================================================================= 
;; I don't know how to write proper tests for html, so sleazytesting via stray 
;; let statements that I evaluate in Lightable will have to do for now. 
(let [dir "/home/thomas/hax0r/grothendieck/src/grothendieck/test/test-site"
      testfile (clojure.java.io/file dir "the first person with a head.wiki")
      othertestfile (clojure.java.io/file dir "title are cool.wiki")]
  (title dir othertestfile)
  (title dir testfile)
  )



;; ============================================================================= 
;; Possible refactoring
;; ============================================================================= 
;; Use protocols?
;;(defrecord WikiDir [path]
;;  File
;;  ())
;;(let [testing "src/test/"])
