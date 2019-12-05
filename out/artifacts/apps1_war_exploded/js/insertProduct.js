function verificationEnteredData(form) {

    var weightProduct = parseFloat(form.productWeight.value);
    var priceProduct = parseFloat(form.productPrice.value);

    if(typeof weightProduct == "number" && !isNaN(weightProduct))
        console.log("Тип поля 'вес' - цифра - все верно");
    else
        console.log("Ошибка ввода поля 'вес' ");

    if(typeof priceProduct == "number" && !isNaN(priceProduct))
        console.log("Тип поля 'цена' - цифра - все верно");
    else
        console.log("Ошибка ввода поля 'цена'")
}