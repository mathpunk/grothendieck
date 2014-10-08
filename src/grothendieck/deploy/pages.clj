(ns grothendieck.deploy.pages
  (:require [markdown.core :refer [md-to-html-string]])
  (:require [hiccup.core :refer [html]])
  (:require [hiccup.def :refer [defhtml]])
  (:require [hiccup.page :refer [include-css include-js]])
  (:require [swiss.arrows :refer :all])
  (:require [garden.core :refer [css]]))

(defn slug [f]
  "Replaces nasty spaces with friendly hyphens, and corrects the extension"
  (-<> f
      (clojure.string/lower-case)
      (clojure.string/replace <> " " "-")
      (clojure.string/replace <> #"\.(wiki|md)" "")
      (str <> ".html")))

(def style (css []))

(defn make-page [{:keys [front body]}]
  "Sticks a little bit of data into a big bunch of html template I found."
  (html
    [:html {:dir "ltr" :lang "en-US"}
      [:head
        [:title (:title front)]
        [:meta {:charset "UTF-8"}]
        [:meta {:name "viewport" :content "width device-width"}]
        [:meta {:name "robots" :content "all"}]
        [:meta {:http-equiv "imagetoolbar" :content "false"}]
        [:meta {:name "MSSmartTagsPreventParsing" :content "true"}]
        [:meta {:name "keywords" :content (:keywords front)}]
        [:meta {:name "author" :content "Thomas Henderson"}]
        [:meta {:name "author" :content "Simon Griffee (template)"
                :url "https://github.com/hypertexthero/typography/blob/master/index.html"}]
        ;[:link {:rel "Shortcut Icon" :href "/public/img/favicon.ico" :type "image/x-icon"}]
       (let [normalize "//cdnjs.cloudflare.com/ajax/libs/normalize/3.0.1/normalize.min.css"
             typography "//cdn.jsdelivr.net/typeplate/1.1.2/typeplate.min.css"
             base  "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
             theme "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css"
             custom style]
         (include-css base theme normalize typography custom))
       (let [base "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"]
             include-js base)]
       [:body [:div {:id "text"} (md-to-html-string body)]]]))
