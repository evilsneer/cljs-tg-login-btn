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
     :data-onauth         (str callback-name "(user)")      ;"lovesexface.telegram_auth.onTelegramAuth(user)"
     :data-radius         "5"
     :parent-sel          :#tg-login-fieldset}
    )
  )

(defn telegram-btn [is-active-atom callback-name]
  (let [onload #(reset! is-active-atom true)
        observer (js/MutationObserver. (fn [mutations]
                                         (doseq [mutation mutations]
                                           (case (aget mutation "type")
                                             "childList" (let [added-nodes (.. mutation -addedNodes)
                                                               added-node (.item added-nodes 0)
                                                               added-tagname (.-tagName added-node)]
                                                           (case added-tagname
                                                             "IFRAME" (do
                                                                        (println "Iframe added")
                                                                        (js/console.log added-node added-tagname)
                                                                        ;(println "adding iframe load listener")
                                                                        (.addEventListener added-node "load" onload)
                                                                        ;(onload)
                                                                        )
                                                             ;(println "another tag added")
                                                             ))
                                             ;(println "another mutation happened")
                                             ))))]
    (reagent.core/create-class {:component-did-mount    (fn []
                                                          (let [element (.getElementById js/document "tg-login-fieldset")
                                                                attributes (js-obj "attributeFilter" ["class"] "childList" true "subtree" true)]
                                                            (.observe observer element attributes)
                                                            ;(println "Tg Button Observer added")
                                                            )
                                                          (load-telegram-btn! callback-name))

                                :component-will-unmount (fn [] (.disconnect observer)
                                                          ;(println "Tg Button Observer unmounted")
                                                          )

                                :reagent-render         (fn []
                                                          [:div#tg-login-fieldset])})))