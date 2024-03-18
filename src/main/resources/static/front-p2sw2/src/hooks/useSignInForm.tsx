import { useState } from 'react';
import axios from 'axios';
import { Report } from 'notiflix/build/notiflix-report-aio';
// import { Link } from 'react-router-dom';

// Hook para manejar el estado y la lógica del formulario de login (Básicamente es una función)
const useSignInForm = () => {
  // Estados para almacenar el email y la clave ingresados por el usuario
  const [email, setEmail] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const url = 'http://localhost:8080/auth/login';

  // Manejadores de cambios para actualizar los estados cuando el usuario ingresa datos en los campos del formulario
  const handleEmailChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    // Axios permite realizar als solicitudes HTTP a la API  https://axios-http.com/docs/
    axios
      .post(url, {
        email: email,
        password: password,
      })
      .then((response) => {
        console.log(response);
        if (response.data.valid) {
          // acá pueden ver la documentacion de la liberia de notificaciones  https://notiflix.github.io/report
          Report.success(
            'Login Exitoso',
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
            'Error al iniciar Sesión',
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
            'Error de inicio de sesión',
            'Ocurrió un error al iniciar sesión. Por favor, intenta nuevamente.',
            'Okay',
          );
        }, 1000);
      });

    console.log('Email:', email);
    console.log('Password:', password);
  };

  return {
    email,
    password,
    handleEmailChange,
    handlePasswordChange,
    handleSubmit,
  };
};

export default useSignInForm;
