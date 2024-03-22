import { useState } from 'react';
import axios from 'axios';
import { Report } from 'notiflix/build/notiflix-report-aio';

interface FormEmpleados{

    nombre: String,
    descripcion: String,
    fecha_creacion: Date,
    empleado: String,

}

const useEmployeeAssignmentForm = () => {
  
  const [formEmpleados, setFormEmpleados] = useState<FormEmpleados>({

    nombre: '',
    descripcion: '',
    fecha_creacion: new Date(),
    empleado: '',

  });

  const handleDateChange = (date: Date | null) => {
    if (date !== null) {
      setFormEmpleados(prevState => ({
        ...prevState,
        fecha_ingreso: date,
      }));
    } else {
      // Detener el flujo del formulario y mostrar un mensaje de error al usuario
      console.error("Por favor, seleccione una fecha.");
      return; // Detener el flujo del formulario
    }
  };

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) =>{

    const {name, value} = e.target;
    setFormEmpleados({
        ...formEmpleados,
        [name]: value,
    })

  };

  const handleChange = (leader: string) => {
    // Tu lógica aquí...
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) =>{
    e.preventDefault();
    const {nombre, descripcion, fecha_creacion,  empleado} = formEmpleados;


    axios
        .post('http://localhost:8080/assignment/empleado',{
            nombre,
            descripcion,
            fecha_creacion,
            empleado
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
    handleChange

  };
};

export default useEmployeeAssignmentForm;