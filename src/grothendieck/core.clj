(ns grothendieck.core
  (:require [grothendieck.pages :refer [make-page]])
  (:require [swiss.arrows :refer :all])
  (:require [grothendieck.front-matter :refer :all])
  ;(:gen-class :main true)
  )

(defn config [dir]
  "Read an edn file called config.edn in the site's dir, or pick some defaults."
  {:sitename "finite.support"})

(defn files [dir]
  "Given a directory name, return the wiki and markdown files."
  (remove (fn [x] (empty?  (re-seq #"\.(md|wiki)" (.getName x))))
          (file-seq (clojure.java.io/file dir))))

(defn preprocessed [file]
  "Given a file, create a map with front-matter and content information."
  {:title (.getName file) :body (slurp file)}
  )

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

;; Some sleazytesting.
(let [dir "/home/thomas/hax0r/grothendieck/src/grothendieck/test/test-site"
      testfile (clojure.java.io/file dir "the first person with a head.wiki")
      othertestfile (clojure.java.io/file dir "title are cool.wiki")]
  (title dir othertestfile
  ;(with-front-matter testfile)
  ))





(defn write-page [target title]
  (fn [f]
    (let [filename (slug (.getName f))
          path (java.io.File. target filename)]
       (spit path (make-page {:title title :keywords "" :body (slurp f)})))))


;; (defn build-site [title source target]
;;   (println "Building site " title " from the " source " directory..................")
;;   (let [please-to-write (write-page target title)]
;;     (map #(please-to-write %) (files source)))
;;   (println "Built " source "site in " target "."))

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

;; Use protocols?
;(defrecord WikiDir [path]
;  File
;  ())
;(let [testing "src/test/"])
