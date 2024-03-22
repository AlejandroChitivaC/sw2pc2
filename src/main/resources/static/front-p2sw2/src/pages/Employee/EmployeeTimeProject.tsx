import Breadcrumb from '../../components/Breadcrumbs/Breadcrumb';
import DefaultLayout from '../../layout/DefaultLayout';
import DatePickerOne from '../../components/Forms/DatePicker/DatePickerOne';

const RegistroEmpleados = () => {
  return (
    <DefaultLayout>
      <Breadcrumb pageName="Registre un nuevo Empleado" />

      <div className="container mx-auto">
        <div className=" justify-center items-center gap-9">
      
          <div className="rounded-sm border border-stroke bg-white shadow-default dark:border-strokedark dark:bg-boxdark">
            <div className="border-b border-stroke py-4 px-6.5 dark:border-strokedark">
              <h3 className="font-medium text-black dark:text-white">
                Tiempo de Empleado en proyecto
              </h3>
            </div>
            <div className="flex flex-col gap-5.5 p-7.5">
              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Nombre
                </label>
                <input
                  type="text"
                  placeholder="Nombre del empleado"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <div className="mb-3 block text-black dark:text-white">
                <DatePickerOne label="Fecha de inicio proyecto"/>
              </div>

              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Tipo de documento
                </label>
                <input
                  type="text"
                  placeholder="Tipo de documento"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Número de documento
                </label>
                <input
                  type="text"
                  placeholder="Número de documento"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <button className="flex w-full justify-center rounded bg-primary p-3 font-medium text-gray hover:bg-opacity-90">
                  Registrar 
                </button>
              
            </div>
          </div>
          
        </div>

      </div>
    </DefaultLayout>
  );
};

export default RegistroEmpleados;
