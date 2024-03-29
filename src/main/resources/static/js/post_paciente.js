$(document).ready(function() {
    $("#add_new_paciente").submit(function(evt) {
        evt.preventDefault();

        let formData = {
            nombre: $("#nombre").val(),
            apellido: $("#apellido").val(),
            dni: $("#dni").val(),
            fechaAlta: $("#fechaAlta").val(),
            domicilio: {
                calle: $("#calle").val(),
                numero: $("#numero").val(),
                localidad: $("#localidad").val(),
                provincia: $("#provincia").val()
            }
        };

        $.ajax({
            url: '/pacientes',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(formData),
            dataType: 'json',
            async: false,
            cache: false,
            success: function(response) {
                console.log(response);
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Paciente agregado </div>';
                $("#response").append(successAlert);
                $("#response").css({ "display": "block" });

                resetUploadForm();
            },
            error: function(xhr, status, error) {
                console.error(error);
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error, intente nuevamente</strong> </div>';
                $("#response").append(errorAlert);
                $("#response").css({ "display": "block" });

                resetUploadForm();
            }
        });
    });

    function resetUploadForm() {
        $("#nombre").val("");
        $("#apellido").val("");
        $("#dni").val("");
        $("#fechaAlta").val("");
        $("#calle").val("");
        $("#numero").val("");
        $("#localidad").val("");
        $("#provincia").val("");
    }
});