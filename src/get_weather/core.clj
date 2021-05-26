(ns get-weather.core
  (:require [clojure.string :as clstr])   ; Used to join city string
  (:require [clojure.java.io :as io])     ; Used to get local file for API KEY
  (:require [clj-http.client :as client]) ; Used for GET request to API
  (:require [cheshire.core :refer :all])) ; Used to parse the JSON file

(def APPID (io/file (io/resource "APPID.txt")))

(def default "Rexburg")

(defn -main [& args]
  (let* [URL (str (format "https://api.openweathermap.org/data/2.5/weather?q=%s&units=imperial&APPID=" 
                          (if (seq args) (clstr/join " " args) default)) (slurp APPID))
         weather-JSON (get (client/get URL {:as :json-strict}) :body)]
    (let [temp (get (get weather-JSON :main) :temp)
          weather (get (get (get weather-JSON :weather) 0) :description)
          wind (get (get weather-JSON :wind) :speed)
          city (get weather-JSON :name)]
      (println (format "In %s it's %s °F with %s and %s mph winds." city temp weather wind)))))
