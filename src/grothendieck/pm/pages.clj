
(ns grothendieck.
  (:require [grothendieck.static.front-matter :refer [with-front-matter]])
  (:require [swiss.arrows :refer :all])
  (:require [markdown.core :refer [md-to-html-string]])
  (:require [hiccup.core :refer [html]])
  (:require [hiccup.def :refer [defhtml]])
  (:require [hiccup.page :refer [include-css include-js]])
  (:require [garden.core :refer [css]]))




;; EDN
;; =============================================================================


; pm chapter edn
[:head
 [:meta]
 ; jquery requirements    ??
 ; annotator requirements ??
 ; typeplate requirements //cdn.jsdelivr.net/typeplate/1.1.2/typeplate.min.css
 [:body
  [:nav#chapters]
  [:section#subchapter]
  [:footer
   [:section#see-also]
   [:section#colophon]]]
 ; annotator script
 ]

; (defn make-page [{:keys [front body template]}]
; "Sticks a little bit of data into a big bunch of html template I found."
;   (html
;     [:html {:dir "ltr" :lang "en-US"}
;       [:head
;         [:title (:title front)]
;         [:meta {:charset "UTF-8"}]
;         [:meta {:name "viewport" :content "width device-width"}]
;         [:meta {:name "robots" :content "all"}]
;         [:meta {:http-equiv "imagetoolbar" :content "false"}]
;         [:meta {:name "MSSmartTagsPreventParsing" :content "true"}]
;         [:meta {:name "keywords" :content (:keywords front)}]
;         [:meta {:name "author" :content "Thomas Henderson"}]
;         [:meta {:name "author" :content "Simon Griffee (template)"
;                 :url "https://github.com/hypertexthero/typography/blob/master/index.html"}]
;;         ;[:link {:rel "Shortcut Icon" :href "/public/img/favicon.ico" :type "image/x-icon"}]
;;        (let [normalize "//cdnjs.cloudflare.com/ajax/libs/normalize/3.0.1/normalize.min.css"
;;              typography "//cdn.jsdelivr.net/typeplate/1.1.2/typeplate.min.css"
;;              base  "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
;;              theme "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css"
;;              custom style]
;;          (include-css base theme normalize typography custom))
;;        (let [base "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"]
;;              include-js base)]
;;        [:body [:div {:id "text"} (md-to-html-string body)]]]))
;;   )

;; (defn page-html [dir f]
;;   (let [; prefix (str (:sitename (config dir)) " | ")
;;         data (with-front-matter f)
;;         page-title (str "Punk Mathematics |"
;;                         (clojure.string/trim (get-in data [:front :title]
;;                                        ;; or make a title out of the filename
;;                                          (-<> f
;;                                              (.getName <>)
;;                                              (clojure.string/split <> #"\.")
;;                                              (first <>) ))))]
;;    (make-page (assoc-in data [:front :title] page-title))))
;;   )



; (defn compile)

;; ===========================================================================
;; (defn write-page [dir f]
;;   (spit (clojure.java.io/file dir "target" (title->slug (.getName f))) (page-html dir f)))

;; (defn build-pages [dir]
;;   (for [f (files dir)]
;;     (write-page dir f)))
