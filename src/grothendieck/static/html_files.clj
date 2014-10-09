(ns grothendieck.static.html-files
  (:require [grothendieck.static.front-matter :refer [with-front-matter]])
  (:require [swiss.arrows :refer :all])
  (:require [markdown.core :refer [md-to-html-string]])
  (:require [hiccup.core :refer [html]])
  (:require [hiccup.def :refer [defhtml]])
  (:require [hiccup.page :refer [include-css include-js]])
  (:require [garden.core :refer [css]]))


;; Helper
(defn title->slug
  ([f]
   "Normalizes titles into link-friendly titles. Standardizes file extension."
    (-<> f
        (clojure.string/lower-case)
        (clojure.string/replace <> " " "-") ; dehyphenation
        (clojure.string/replace <> #"\.(wiki|md|my)" ".html"))))



;; (try
;;   (title->slug (get-in text [:front :title]))
;; (try
;;   (title->slug (.getName (:file text)))
;; (try
;;   "untitled"
;; (throw "something horrible is happening, like a filename collision")




;; ; theatrical html
;; ; -------------------------------------------------
;; ; scenes =>  section id
;; ; staging => section classes
;; ; non-copy content => style informed by stages and scenes
;; ;
;; ; art direction => sprites and backgrounds
;; ; animation => frame bundle and camera (projective plane)

;; (def style (css []))

;; (defn make-page [{:keys [front body template]}]
;;   "Sticks a little bit of data into a big bunch of html template I found."
;; ;;   (html
;; ;;     [:html {:dir "ltr" :lang "en-US"}
;; ;;       [:head
;; ;;         [:title (:title front)]
;; ;;         [:meta {:charset "UTF-8"}]
;; ;;         [:meta {:name "viewport" :content "width device-width"}]
;; ;;         [:meta {:name "robots" :content "all"}]
;; ;;         [:meta {:http-equiv "imagetoolbar" :content "false"}]
;; ;;         [:meta {:name "MSSmartTagsPreventParsing" :content "true"}]
;; ;;         [:meta {:name "keywords" :content (:keywords front)}]
;; ;;         [:meta {:name "author" :content "Thomas Henderson"}]
;; ;;         [:meta {:name "author" :content "Simon Griffee (template)"
;; ;;                 :url "https://github.com/hypertexthero/typography/blob/master/index.html"}]
;; ;;         ;[:link {:rel "Shortcut Icon" :href "/public/img/favicon.ico" :type "image/x-icon"}]
;; ;;        (let [normalize "//cdnjs.cloudflare.com/ajax/libs/normalize/3.0.1/normalize.min.css"
;; ;;              typography "//cdn.jsdelivr.net/typeplate/1.1.2/typeplate.min.css"
;; ;;              base  "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
;; ;;              theme "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css"
;; ;;              custom style]
;; ;;          (include-css base theme normalize typography custom))
;; ;;        (let [base "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"]
;; ;;              include-js base)]
;; ;;        [:body [:div {:id "text"} (md-to-html-string body)]]]))
;;   )

;; (defn page-html [dir f]
;; ;;   (let [; prefix (str (:sitename (config dir)) " | ")
;; ;;         data (with-front-matter f)
;; ;;         page-title (str "Punk Mathematics |"
;; ;;                         (clojure.string/trim (get-in data [:front :title]
;; ;;                                        ;; or make a title out of the filename
;; ;;                                          (-<> f
;; ;;                                              (.getName <>)
;; ;;                                              (clojure.string/split <> #"\.")
;; ;;                                              (first <>) ))))]
;; ;;    (make-page (assoc-in data [:front :title] page-title))))
;;   )
;; (ns leiningen.grot
;;   "This is supposed to be a sort of build tool for static sites. I haven't quite
;;   cracked the syntax for doing 'lein grot built foo bar' yet though."
;;   (:require [swiss.arrows :refer :all])
;;   (:require [grothendieck.static.front-matter :refer :all])
;;   (:require [grothendieck.static.html-files :refer :all]))

;; ;; =============================================================================
;; ;; Preprocessing
;; ;; =============================================================================
;; ;; Read some configuration (currently cheating)
;; ;; Get the text content files from the dir.
;; ;; Helpful functions for making titles and filenames.

;; (defn config [dir]
;;   "Read an edn file called config.edn in the site's dir, or pick some defaults."
;;   {:sitename "finite.support"})

;; (defn files [dir]
;;   "Given a directory name, return the wiki and markdown files."
;;   (remove (fn [x] (empty?  (re-seq #"\.(md|wiki)" (.getName x))))
;;           (file-seq (clojure.java.io/file dir))))


;; ;; ========================================================================================
;; ;; Building
;; ;; ========================================================================================
;; ;; Okay cool. Now you've got your file processing methods, and you ought should be able to
;; ;; use front-matter and everything. So how do you actually build a site?
;; ;;
;; ;; It should:
;; ;; 1. Take a dir to look for text content.
;; ;; 2. The dir should have a "target" dir to take the html.
;; ;; 3? Check if it's marked, :publish? yes or true
;; ;; 4. For each publishable file, use its preprocess into a map to make html.


;; ;; ===========================================================================
;; ;; I/0
;; ;; ===========================================================================
;; ;; (defn write-page [dir f]
;; ;;   (spit (clojure.java.io/file dir "target" (title->slug (.getName f))) (page-html dir f)))

;; ;; (defn build-pages [dir]
;; ;;   (for [f (files dir)]
;; ;;     (write-page dir f)))



;; ;; ;; =============================================================================
;; ;; ;; Testing
;; ;; ;; =============================================================================
;; ;; ;; I don't know how to write proper tests for html, so sleazytesting via stray
;; ;; ;; let statements that I evaluate in Lightable will have to do for now.

;; ;; (let [dir "/home/thomas/hax0r/grothendieck/test/grothendieck/test-site/content"
;; ;;       testfile (clojure.java.io/file dir "the first person with a head.wiki")
;; ;;       othertestfile (clojure.java.io/file dir "title are cool.wiki")
;; ;;       testnofront (clojure.java.io/file dir "backstaging.wiki")]
;; ;;   (build-pages dir))


;; ;; ;; ===========================================================================
;; ;; ;; Here are some garbage notes on things that may or may not want to be written in bash.
;; ;; ;;
;; ;; ;; bash looks to see if anything important has changed.
;; ;; ;; future: clj, read the headers if any
;; ;; ;;   publishable?
;; ;; ;;   :title
;; ;; ;;   :keywords
;; ;; ;;   :slug
;; ;; ;;   :site
;; ;; ;;   :category
;; ;; ;; and
;; ;; ;;   :body
;; ;; ;; take the file's contents,
;; ;; ;; give them to chapter/page
;; ;; ;; spit the result to target.
;; ;; ;;
;; ;; ;;
;; ;; ;; =============================================================================
;; ;; ;; Possible refactoring
;; ;; ;; =============================================================================
;; ;; ;; Use protocols?
;; ;; ;;(defrecord WikiDir [path]
;; ;; ;;  File
;; ;; ;;  ())
;; ;; ;;(let [testing "src/test/"])


