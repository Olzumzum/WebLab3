$(document).ready(function () {
    /** Диалог о несовпадении паролей */
    $('#dialog').dialog({
        autoOpen: false
    });
    /** Диалог об успешной регистрации */
    $('#succsess_dialog').dialog({
        autoOpen: false
    });
    /** Диалог о непройденной капче */
    $('#capcha_dialog').dialog({
        autoOpen: false
    });
});