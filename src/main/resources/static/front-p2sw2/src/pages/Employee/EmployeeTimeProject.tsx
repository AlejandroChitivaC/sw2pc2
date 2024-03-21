import Breadcrumb from '../../components/Breadcrumbs/Breadcrumb';
import DefaultLayout from '../../layout/DefaultLayout';
import DatePickerOne from '../../components/Forms/DatePicker/DatePickerOne';
import SelectGroupOne from '../../components/Forms/SelectGroup/SelectGroupOne';

const EmployeeTimeProject = () => {
  return (
    <DefaultLayout>
      <Breadcrumb pageName="Registre el tiempo para un empleado" />

      <div className="container mx-auto">
        <div className=" justify-center items-center gap-9">
      
          <div className="rounded-sm border border-stroke bg-white shadow-default dark:border-strokedark dark:bg-boxdark">
            <div className="border-b border-stroke py-4 px-6.5 dark:border-strokedark">
              <h3 className="font-medium text-black dark:text-white text-center">
                Tiempo de Empleados en el proyecto
              </h3>
            </div>
            <div className="flex flex-col gap-5.5 p-7.5">

                <div className="mb-3 block text-black dark:text-white">
                  <SelectGroupOne labelText="Proyecto" selectPlaceholder="Seleccione el nombre del proyecto"/>
                </div>

                <div className="mb-3 block text-black dark:text-white">
                  <SelectGroupOne labelText="Empleado" selectPlaceholder="Seleccione el empleado para su seguimiento"/>
                </div>

                <div className="mb-4.5">
                  <label className="mb-2.5 block text-black dark:text-white">
                    Horas trabajadas
                  </label>
                  <input
                    type="number"
                    placeholder="12"
                    className="w-full rounded border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                  />
                </div>

                <div className="mb-3 block text-black dark:text-white">
                    <DatePickerOne label="Fecha de registro"/>
                </div>

                <button className="inline-flex items-center mx-auto justify-center rounded-full  bg-meta-3 py-4 px-10 text-center font-medium text-white hover:bg-opacity-90 lg:px-8 xl:px-10">
                  Registrar Tiempo
                </button>
              
            </div>
          </div>
          
        </div>

      </div>
    </DefaultLayout>
  );
};

export default EmployeeTimeProject;