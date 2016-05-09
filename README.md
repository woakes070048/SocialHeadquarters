## Social Headquarters

Aim of the project is allow people (or companies) to manage their accounts on social portals like
Twitter, Facebook, Linkedin, and to gather all kind of information's from these social portals and
place them in Elasticsearch (non relational) database engine. In future functionalities gathered
data would be automatically searched and used to trigger some events.


## Functionalities availible now:

- Adding users to database (administration);
- Adding brands to database;
- Enter 'Manage Brand' page;
- Connect to Facebook and get (brand) Profile and (brand)Likes data as JSON;
- Basic integration tests on server side;
- Basic e2e and unit tests on frontend side;


## Dependencies

You need to have Elasticsearch database available on your system (up and running). Application is
using 9200 binary port to communicate with Elasticsearch.


## Running

You can create project 'war' file using 'mvn install' and run it on servlet container or enterprise
server. For development purpose you can use Jetty plugin using 'mvn jetty:run' command.


## Testing

You can test backend by using maven. Just run 'mvn test'. Project test uses Elasticsearch
database engine running within the test configuration (embedded).

To test AngularJS you need to change directory to '/src/webapp/resources/static/js'
and run 'npm protractor' for e2e tests (Protractor) or 'npm test' for unit tests(Karma).


## Licence

Project uses a MIT licence .

MIT License

Copyright (c) 2016 Michal Kostewicz

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.