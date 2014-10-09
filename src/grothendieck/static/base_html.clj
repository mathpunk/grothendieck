
(ns grothendieck.static.base-html
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
