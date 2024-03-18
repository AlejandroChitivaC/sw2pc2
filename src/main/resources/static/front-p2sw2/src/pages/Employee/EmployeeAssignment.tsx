import Breadcrumb from '../../components/Breadcrumbs/Breadcrumb';
import DefaultLayout from '../../layout/DefaultLayout';
import DatePickerOne from '../../components/Forms/DatePicker/DatePickerOne';
import SelectGroupOne from '../../components/Forms/SelectGroup/SelectGroupOne';

const AsignacionEmpleados = () => {
  return (
    <DefaultLayout>
      <Breadcrumb pageName="Asigne un empleado" />

      <div className="container mx-auto">
        <div className=" justify-center items-center gap-9">
      
          <div className="rounded-sm border border-stroke bg-white shadow-default dark:border-strokedark dark:bg-boxdark">
            <div className="border-b border-stroke py-4 px-6.5 dark:border-strokedark">
              <h3 className="font-medium text-black dark:text-white">
                Proyecto
              </h3>
            </div>
            <div className="flex flex-col gap-5.5 p-6.5">
              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Nombre
                </label>
                <input
                  type="text"
                  placeholder="Nombre del proyecto"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Descripción
                </label>
                <input
                  type="text"
                  placeholder="El proyecto..."
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <div className="mb-3 block text-black dark:text-white">
                <DatePickerOne label="Fecha de inicio"/>
                <DatePickerOne label="Fecha de finalización"/>
              </div>

              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Presupuesto
                </label>
                <input
                  type="number"
                  placeholder="25000000.00"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Estado
                </label>
                <input
                  type="text"
                  placeholder="En ejecución"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <div className="mb-3 block text-black dark:text-white">
                  <SelectGroupOne />
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

export default AsignacionEmpleados;
