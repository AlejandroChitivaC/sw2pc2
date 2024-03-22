import Breadcrumb from '../../components/Breadcrumbs/Breadcrumb';
import DefaultLayout from '../../layout/DefaultLayout';
import DatePickerOne from '../../components/Forms/DatePicker/DatePickerOne';
import SelectGroupOne from '../../components/Forms/SelectGroup/SelectGroupOne';
import useEmployeeResgitrationForm from '../../hooks/useEmployeeRegistrationForm';
import useEmployeeAssignmentForm from '../../hooks/useEmployeeAssignmentForm';


const EmployeeAssignment = () => {

  const{
    formEmpleados,
    handleDateChange,
    handleSubmit,
    handleInputChange,
    handleChange
  } = useEmployeeAssignmentForm();

  return (
    <DefaultLayout>
      <Breadcrumb pageName="Asigne un empleado" />

      <div className="container mx-auto">
        <div className=" justify-center items-center gap-9">
      
          <div className="rounded-sm border border-stroke bg-white shadow-default dark:border-strokedark dark:bg-boxdark">
            <div className="border-b border-stroke py-4 px-6.5 dark:border-strokedark">

              <h3 className="font-medium text-black dark:text-white">
                Asignacion de equipo

              </h3>
            </div>
            <div className="flex flex-col gap-5.5 p-6.5">
              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Nombre equipo
                </label>
                <input
                  type="text"
                  placeholder="Nombre del equipo"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Descripción
                </label>
                <input
                  type="text"
                  placeholder="Descripción del equipo"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <div className="mb-3 block text-black dark:text-white">
                <DatePickerOne label="Fecha de creación" onChange={handleDateChange} value={formEmpleados.fecha_creacion}/>
              </div>

              <div className="mb-3 block text-black dark:text-white">
                  <SelectGroupOne onChange={(leader: string) => handleChange(leader)} labelText="Empleado" selectPlaceholder="Seleccione el empleado que desea asignar"/>
                </div>
                <input 
                type="submit"
                value="Registrar"
                className="inline-flex items-center mx-auto justify-center rounded-full  bg-meta-3 py-4 px-10 text-center font-medium text-white hover:bg-opacity-90 lg:px-8 xl:px-10">
              </input>
              
            </div>
          </div>
          
        </div>

      </div>
    </DefaultLayout>
  );
};

export default EmployeeAssignment;