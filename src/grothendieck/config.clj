(ns grothendieck.config
  (:require [garden.core :refer [css]]
            [hiccup.core :refer [html]]))

;; How will your users set the config? the templates?
;; So the config file ought to have space to put in templates.
;; This suggests crazy ideas like,
;; put the endpoint and hiccup/garden in the config file with reader commands,
;; and do the md transformation with a *template* binding.
;; That is a rad idea.
;; That is... not something I've done successfully before.
;; It sounds a bit unlikely to nail in one steady burst of thought.
;; A better idea might be, to grab the functions that I know do it,
;; and use those solutions for now.
;; The more general solution is a cool and useful idea that would be a challenging problem
;; for another time.

(def structure
  (html [:head
         [:title "Introducing CSS"]
         [:link {:href "css/example.css" :type "text/css" :rel "stylesheet"}]]
        [:body
         [:h1 "From Garden to Plate"]
         [:p "A <i>potager</i> is a French term for an ornamentail vegetable or kitchen garden ..."]
         [:h2 "What to Plant"]
         [:p "Plants are chosen as much for their functionality as for their color and form ..."]
         ])
  )

(def style
  (css [:body {:font-family "Arial, Verdana, sans-serif"}]
       [:h1, :h2 {:color "#ee3e80"}]
       [:p {:color "#665544"}]))

(def structure-and-style
  (html [:head
         [:title "Using Internal CSS"]
         [:style {:type "text/css"}
          (css [:body {:font-family "arial" :background-color "rgb(185,179,175)"}]
               [:h1 {:color "rgb(255,255,255" }])]
         ]
        [:body
         [:h1 "Potatoes"]
         [:p "There are dozens of different variets of potatoes."]]))

