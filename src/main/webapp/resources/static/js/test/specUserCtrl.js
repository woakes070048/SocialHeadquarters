describe('user administration panel', function() {
  var userCountBefore;

  var generateUserName = function() {
        var autoGenerateUserName = "Selenium-user-";
        var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (var i = 0; i < 3; i++)
            autoGenerateUserName += possible.charAt(Math.floor(Math.random() * possible.length));
        return  autoGenerateUserName;
    };

  beforeEach(function() {
      browser.get('http://localhost:8080/#/users');
     element.all(by.repeater('u in ctrl.users')).count().then(function(count) {
              userCountBefore = count;
             });
    });

  it('should add user', function() {
    browser.get('http://localhost:8080/#/users');
    expect(browser.getTitle()).toEqual('Social Headquarters');

     element(by.model('ctrl.user.email')).sendKeys('test@wpp.pl');
     element(by.model('ctrl.user.address')).sendKeys("Address, Somecity");
     element(by.model('ctrl.user.name')).sendKeys(generateUserName());
     element(by.id('addbutton')).click();
     var userCountAfter = element.all(by.repeater('u in ctrl.users')).count();
     expect(userCountAfter).toEqual(userCountBefore+1);
  });
});