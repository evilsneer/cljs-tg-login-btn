(ns cljs-tg-login-btn.core
  (:require [reagent.core]
            [cljs-add-script.core :refer [add-script!]]))

(defn- load-telegram-btn! [callback-name]
  (add-script! "https://telegram.org/js/telegram-widget.js?5"
    (fn [e]
      (println "Telegram login script loaded"))
    {:async               "async"
     :data-telegram-login "emptyonedishauth_bot"
     :data-size           "medium"
     :data-userpic        "false"
     :data-onauth         (str callback-name "(user)")
                          :data-radius         "5"
                          :parent-sel          :#tg-login-fieldset}))

(defn telegram-btn [is-active-atom callback-name]
  (let [observer (js/MutationObserver. (fn [mutations]
                                         (doseq [mutation mutations]
                                           (case (aget mutation "type")
                                             "childList" (do
                                                           (println "child added")
                                                           (js/console.log mutation)
                                                           (reset! is-active-atom true))
                                             :default (println "another mutation happened")))))]
    (reagent.core/create-class {:component-did-mount    (fn []
                                                          (let [element (.getElementById js/document "tg-login-fieldset")
                                                                attributes (js-obj "attributeFilter" ["class"] "childList" true)]
                                                            (.observe observer element attributes)
                                                            (println "Tg Button Observer added"))
                                                          (load-telegram-btn! callback-name))

                                :component-will-unmount (fn [] (.disconnect observer) (println "Tg Button Observer unmounted"))

                                :reagent-render         (fn []
                                                          [:div#tg-login-fieldset])})))