;; ================================================================
;; Let's do File IO
;; ================================================================
(ns ebook.server
  (:require [markdown.core :as md]
            [clojure.java.io :as io]
            ; [hiccup.core :refer [html]]
            [net.cgrand.enlive-html :as html]
            ; [hiccup.page :refer [html5 include-css include-js]]
            ))


(def BASEURL "/home/thomas/pm/book/")
(def compiled-url "/home/thomas/pm/book/Posted")
(def compiled-file "/home/thomas/pm/book/Posted/test.md")
(def metadocuments (str BASEURL "Metadocuments/"))
(def compiled (str BASEURL "Compiled/"))
(def posted (str BASEURL "Posted/"))

(html/deftemplate chapter (io/input-stream "/home/thomas/Sites/mathpunk.net/ebook/resources/public/templates/chapter.html")
  [markdown-file]
  [:div#text] (html/html-content (md/md-to-html-string (slurp markdown-file))))

(def chapter-correspondence
  {:base compiled
   :1 "Compiled Version of Domains"
   :2 "Compiled Chapter on Order.md"})

(defn make-chapter [n]
  (let [base (:base chapter-correspondence)
        slug ((clojure.core/keyword (str n)) chapter-correspondence)
        markdown-file (str base slug)]
    (chapter markdown-file)))


;(defroutes app-routes
; (GET "/" [] (chapter (str metadocuments "Brief Contents.md")))
; (GET "/proposal" [] (chapter (str metadocuments "proposal.md")))
; (GET "/chapter/:n" [n] (make-chapter n))
; ;(GET "/data" [] (alchemy-full-page test-data))
; (route/resources "/")
; (route/not-found "Not Found"))

;def app
; (handler/site app-routes))



;(spit "/home/thomas/Exercises/example.html" example-structure)
;(spit "/home/thomas/Exercises/css/example.css" example-style)

