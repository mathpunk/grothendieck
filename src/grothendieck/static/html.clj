(ns grothendieck.static.html
  (:require [grothendieck.static.front-matter :refer [with-front-matter]])
  (:require [swiss.arrows :refer :all])
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
  ; AHHHHHHHHHHHHHHh
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

(defn page-html [dir f]
  (let [; prefix (str (:sitename (config dir)) " | ")
        data (with-front-matter f)
        page-title (str "Punk Mathematics |"
                        (clojure.string/trim (get-in data [:front :title]
                                       ;; or make a title out of the filename
                                         (-<> f
                                             (.getName <>)
                                             (clojure.string/split <> #"\.")
                                             (first <>) ))))]
   (make-page (assoc-in data [:front :title] page-title))))

;; And some sleazytesting:

(let [dir "/home/thomas/hax0r/grothendieck/test/grothendieck/test-site/content"
      testfile (clojure.java.io/file dir "the first person with a head.wiki")
      othertestfile (clojure.java.io/file dir "title are cool.wiki")
      testnofront (clojure.java.io/file dir "backstaging.wiki")]
  (page-html dir testfile))
