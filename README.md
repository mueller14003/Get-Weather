# get-weather

This repo includes a simple Clojure Leiningen project that does an API call to display weather data for any given city.

## Installation

### Leiningen

To run this code, you will need to have Leiningen installed.

To do so, follow the instructions on this website for your corresponding operating system: https://purelyfunctional.tv/guide/how-to-install-clojure/

### API Key

Make sure that you have your own API key for OpenWeatherMap.

This can be done by signing up for free at https://home.openweathermap.org/users/sign_up

When you have your API key, create a resources folder in your cloned repository, and create a file within the folder. The file should be named "APPID.txt".

Once this is done, paste your API key within the document.

## Usage

Once you have Leiningen installed, open a terminal, navigate to the project directory, and use the following command:

    $ lein run

## Options

To change the city that you would like to see the weather data for, navigate to src/get_weather/core.clj and change the city-name variable according to your preference.
