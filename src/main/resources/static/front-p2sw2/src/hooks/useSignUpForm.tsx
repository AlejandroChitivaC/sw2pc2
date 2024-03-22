import { useState } from 'react';
import axios from 'axios';
import { Report } from 'notiflix/build/notiflix-report-aio';

interface FormData {
    email: string;
    usuario: string;
    password: string;
    confirmPassword: string;
}

const useSignUpForm = () => {
    const [formData, setFormData] = useState<FormData>({
        email: '',
        usuario: '',
        password: '',
        confirmPassword: '',
    });

    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        const { email, usuario, password, confirmPassword } = formData;

        // Verificar si las contraseñas coinciden
        if (password !== confirmPassword) {
            Report.failure('Error de registro', 'Las contraseñas no coinciden', 'Ok');
            return;
        }

        axios
            .post('http://localhost:8080/auth/register', {
                email,
                usuario,
                password,
            })
            .then((response) => {
                console.log(response);
                if (response.data.valid) {
                    Report.success('Registro Exitoso', response.data.message, 'Ok');
                } else {
                    Report.failure('Error de registro', response.data.message, 'Ok');
                }
            })
            .catch((error) => {
                console.log('Error en la solicitud:', error);
                Report.failure('Error de registro', 'Ocurrió un error al registrar. Por favor, intenta nuevamente.', 'Ok');
            });

        console.log('Form Data:', formData);
    };

    return {
        formData,
        handleInputChange,
        handleSubmit,
    };
};

export default useSignUpForm;