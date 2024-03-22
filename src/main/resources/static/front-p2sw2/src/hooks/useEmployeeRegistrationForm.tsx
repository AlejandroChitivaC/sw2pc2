import { useState } from 'react';
import axios from 'axios';
import { Report } from 'notiflix/build/notiflix-report-aio';

interface FormEmpleados{

    nombre: String,
    direccion: String,
    salario: String,
    fecha_ingreso: Date,
    fecha_nacimiento: Date,
    tipo_documento_id: String,
    numero_documento: String,
    telefono: String,

}

const useEmployeeRegistrationForm = () => {
  
  const [formEmpleados, setFormEmpleados] = useState<FormEmpleados>({

    nombre: '',
    direccion: '',
    salario: '',
    fecha_ingreso: new Date(),
    fecha_nacimiento: new Date(),
    tipo_documento_id: '',
    numero_documento: '',
    telefono: '',

  });

  const handleDateChange = (date: Date | null) => {
    if (date !== null) {
      setFormEmpleados(prevState => ({
        ...prevState,
        fecha_ingreso: date,
      }));
    } else {
      // Manejar el caso en el que no hay fecha seleccionada, por ejemplo, mostrando un mensaje de error
      console.error("Por favor, seleccione una fecha.");
    }
  };

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) =>{

    const {name, value} = e.target;
    setFormEmpleados({
        ...formEmpleados,
        [name]: value,
    })

  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) =>{
    e.preventDefault();
    const {nombre, direccion, salario, fecha_ingreso, fecha_nacimiento, tipo_documento_id, numero_documento, telefono} = formEmpleados;


    axios
        .post('http://localhost:8080/registrar/addEmployee',{
            nombre,
            direccion,
            salario,
            fecha_ingreso,
            fecha_nacimiento,
            tipo_documento_id,
            numero_documento,
            telefono,
        })
        .then((response) => {
            console.log(response);
            if(response.data.valid){
                Report.success('Registro Exitoso', response.data.message, 'OK');
            } else{
                Report.failure('Error de registro', response.data.message, 'OK');
            }
        })

        .catch((error)=>{
            console.log('Error en la solicitud:', error);
            Report.failure('Error de registro', 'Ocurrio un error al registrar empleado. Por favor, intente nuevamente.','OK');

        });

        console.log('Form Empleado', formEmpleados);

  };

  return {
    formEmpleados,
    handleDateChange,
    handleInputChange,
    handleSubmit,

  };
};

export default useEmployeeRegistrationForm;