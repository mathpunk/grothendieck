hiccup.page :as page
hiccup.element :as elem

[:html
 [:head
  ;jquery, annotator-full
  (page/include-js 
    "http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"
    "http://assets.annotateit.org/annotator/v1.2.9/annotator-full.min.js")
  (page/include-css "http://assets.annotateit.org/annotator/v1.2.9/annotator.min.css")
  ;typeplate
  ,,,
  ;responsive
  ,,,]
  ;front-matter

 [:body (:body text)]
 (make-annotateable "chapter>p")
 (authenticate)
 (store)]


;; I think you're putting too much in here maybe? 




(defn make-annotateable [sel]
  (elem/javascript-tag
    (str "jQuery(function ($) {
        $('" sel "').annotator();
    });")))


