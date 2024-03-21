import { useState } from 'react';
import axios from 'axios';
import { Report } from 'notiflix/build/notiflix-report-aio';
import { defaults } from 'flatpickr/dist/types/options';

const useProjectRegistrationForm = () => {

    const [projectName, setProjectName] = useState<string>();
    const [projectDescription, setProjectDescription] = useState<string>();
    const [budget, setBudget] = useState<string>();
    const url = '';

    const handelNameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setProjectName(e.target.value);
    }

    const handelDescriptionChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setProjectDescription(e.target.value);
    }

    const handelBudgetChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setBudget(e.target.value);
    };

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) =>{
        e.preventDefault();

        axios
            .post(url, {
                projectName: projectName,
                projectDescription: projectDescription,
            })
            .then((response) => {
                console.log(response);
                if (response.data.valid) {
                    // acá pueden ver la documentacion de la liberia de notificaciones  https://notiflix.github.io/report
                    Report.success(
                        'Proyecto creado',
                        // Esto es un template string, permite pasar una variable como un valor de texto ${var}
                        `${response.data.message}`,
                        'Ok',
                    );

                    //setTimeOut, es para definir un tiempo de espera para que se ejecute lo que está dentro
                    setTimeout(() => {
                        // Redirecciona a Dashboard (LAS RUTAS LAS ENCUENTRAN EN  *App.tsx*)
                        window.location.href = '/index/dashboard';
                        // <Link to="index/dashboard"></Link>;
                    }, 500);
                } else {
                    Report.failure(
                     'Error al crear proyecto',
                     // Esto es un template string, permite pasar una variable como un valor de texto ${var}
                     `${response.data.message}`,
                     'Ok',
                    );
                }
            })
            .catch((error) => {
                // Manejar el error de la solicitud a la API (Spring)
                console.log('Error en la solicitud:', error);
                // Mostrar un mensaje de error al usuario
                setTimeout(() => {
                    Report.failure(
                        'Error de crear proyecto',
                        'Ocurrió un error al proyecto. Por favor, intenta nuevamente.',
                        'Okay',
                    );
                }, 1000);
            });
        
        console.log();
        console.log();
    };


    return{
        projectName,
        projectDescription,
        budget,
        handleSubmit,
        handelNameChange,
        handelDescriptionChange,
        handelBudgetChange,
    }

};

export default useProjectRegistrationForm;