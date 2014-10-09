(ns grothendieck.pm.plugins
  (:require [hiccup.page :as page]))




;; Auth
;; Permissions
;; Store
;; Tags
;; Filter
;; Unsupported plugins.
;; If the Showdown library has been included on the page the Markdown Plugin will also be
;; loaded.

;; Don't forget that you've practically got a Markdown parser written already, and so
;; we may not be able to be arsed with this.

;; jQuery(function ($) {
;;     // Customise the default plugin options with the third argument.
;;     $('#content').annotator()
;;                  .annotator('setupPlugins', {}, {
;;                    // Disable the tags plugin
;;                    Tags: false,
;;                    // Filter plugin options
;;                    Filter: {
;;                      addAnnotationFilter: false, // Turn off default annotation filter
;;                      filters: [{label: 'Quote', property: 'quote'}] // Add a quote filter
;;                    }
;;                  });
;; });
;; // Setting up the default plugins

;; // We include a special setup function in the annotator-full.min.js file that installs all the default plugins for you automatically. To run it just add a call to .annotator("setupPlugins").

;; jQuery(function ($) {
;;     $('#content').annotator()
;;                  .annotator('setupPlugins');
;; });
