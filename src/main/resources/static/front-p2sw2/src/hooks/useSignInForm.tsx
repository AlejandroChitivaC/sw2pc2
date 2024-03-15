import { useState } from 'react';
import axios from 'axios';
import { Report } from 'notiflix/build/notiflix-report-aio';
import { Link } from 'react-router-dom';

// Hook personalizado para manejar el estado y la lógica de un formulario de inicio de sesión
const useSignInForm = () => {
  // Estados para almacenar el email y la clave ingresados por el usuario
  const [email, setEmail] = useState<string>('');
    const [password, setPassword] = useState<string>('');
    const url = "http://localhost:8080/auth/login";

  // Manejadores de cambios para actualizar los estados cuando el usuario ingresa datos en los campos del formulario
  const handleEmailChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPassword(e.target.value);
  };

  // Función para manejar el envío del formulario
    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
      
      e.preventDefault();
        axios.post(url,
            {
                email: email,
                password: password
            }
        )
  .then(response => {
    // Manejar la respuesta exitosa aquí
    console.log('Respuesta del servidor:', response.data);
    // Mostrar un mensaje de éxito o redirigir al usuario
    setTimeout(() => {
      Report.success(
        'Login Exitoso',
        `Hola ${email}. Será redireccionado a la página principal.`,
        'Okay'
      );
    }, 1500);
      <Link to="/dashboard"></Link>
  })
  .catch(error => {
    // Manejar el error de la solicitud
    console.error('Error en la solicitud:', error);
    // Mostrar un mensaje de error al usuario
    Report.failure(
      'Error de inicio de sesión',
      'Ocurrió un error al iniciar sesión. Por favor, intenta nuevamente.',
      'Okay'
    );
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
