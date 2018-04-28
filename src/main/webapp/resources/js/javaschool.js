
cryptPassword = function () {
    password = document.getElementById("password").value;
    password = md5(password);
    document.getElementById("password").value = password;
    return true;
};
