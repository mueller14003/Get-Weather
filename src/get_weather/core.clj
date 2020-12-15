(ns get-weather.core
  (:require [clojure.java.io :as io])
  (:require [clj-http.client :as client])
  (:require [cheshire.core :refer :all]))

(def APPID (io/file (io/resource "APPID.txt")))

(def city-name "Rexburg")

(defn -main []
  (let* [URL (str (format "https://api.openweathermap.org/data/2.5/weather?q=%s&units=imperial&APPID=" city-name) (slurp APPID))
         weather-JSON (get (client/get URL {:as :json-strict}) :body)]
    (let [temp (get (get weather-JSON :main) :temp)
          weather (get (get (get weather-JSON :weather) 0) :description)
          wind (get (get weather-JSON :wind) :speed)
          city (get weather-JSON :name)]
      (println (format "In %s it's %s F with %s and %s mph winds." city temp weather wind)))))
