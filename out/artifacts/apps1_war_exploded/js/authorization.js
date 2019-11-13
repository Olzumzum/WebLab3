/**
 *  Валидация
 **/
function valid(form) {
    /**адрес для перехода по ссылке в случае успешного завершения действия */
    const url = "../sheets/persanal_area.html";

    /** Объявление переменных, присвоение значений,
     * полученных из формы*/
    var email = "";
    var password = "";
    email = form.email.value;
    password = form.password.value;

    /**Получение данных с сервера */
   /* const json = getData();
    const object = JSON.parse(json);
    var userEmail = object["email"];
    var userPassword = object["password"];

    /* Здесь проверяем полученные данные */
    /*  if (email != userEmail || password != userPassword) {
          console.log("negative");
          $("#dialog").dialog("open");
      } else {
          console.log("positive");
          document.location.href = url;
      }*/
};

/**
 * Получение данных с сервера
 */
function getData() {
    /**
     * JSon надо буде как-то получать с сервера
     * @type {{password: string, email: string}}
     */
    let user = '{' +
        '"email": "user@mail.ru",' +
        ' "password": "2"' +
        '}';

    /*Возможо, вот так в будущем будем получать данные */
    /*  var requestUrl = "https://";
      var request = new XMLHttpRequest();
      request.open('GET', requestUrl);
      request.responseType = 'json';
      request.send();

      request.onload = function () {
          var users = request.response;

      }*/
    return user;
}
