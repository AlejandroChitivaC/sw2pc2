// @ts-ignore
import React, { useState } from 'react';
import axios from 'axios';
import { Report } from 'notiflix/build/notiflix-report-aio';

const useSignUpForm = () => {
    const [formData, setFormData] = useState({
        usuario: '',
        email: '',
        password: '',
        confirmPassword: ''
    });

    const url = 'http://localhost:8080/auth/register';

    const handleSubmit = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();

        if (formData.password !== formData.confirmPassword) {
            alert('Las contraseñas no coinciden');
            return;
        }

        try {
            const response = await axios.post(url, {
                usuario: formData.usuario,
                email: formData.email,
                password: formData.password
            });

            if (response.data.valid) {
                Report.success(
                    'Registro Exitoso',
                    `${response.data.message}`,
                    'Ok',
                );
            } else {
                Report.failure(
                    'Error al registrar',
                    `${response.data.message}`,
                    'Ok',
                );
            }
        } catch (error) {
            console.error('Error al enviar los datos:', error);
            Report.failure(
                'Error de registro',
                'Ocurrió un error al registrar. Por favor, intenta nuevamente.',
                'Okay',
            );
        }
    };

    const handleInputChange = (e: { target: { name: any; value: any; }; }) => {
        const { name, value } = e.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    return {
        formData,
        handleSubmit,
        handleInputChange
    };
};

export default useSignUpForm;

