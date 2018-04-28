cryptPassword = function () {
    document.getElementById('password').value = md5(document.getElementById('password').value);
    return true;
};
