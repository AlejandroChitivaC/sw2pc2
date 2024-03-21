import Breadcrumb from '../../components/Breadcrumbs/Breadcrumb';
import DefaultLayout from '../../layout/DefaultLayout';
import DatePickerOne from '../../components/Forms/DatePicker/DatePickerOne';

const EmployeeRegistration = () => {
  return (
    <DefaultLayout>
      <Breadcrumb pageName="Registre un nuevo Empleado" />

      <div className="container mx-auto">
        <div className=" justify-center items-center gap-9">
      
          <div className="rounded-sm border border-stroke bg-white shadow-default dark:border-strokedark dark:bg-boxdark">
            <div className="border-b border-stroke py-4 px-6.5 dark:border-strokedark">
              <h3 className="font-medium text-black dark:text-white text-center">
                Empleado
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

              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Dirección
                </label>
                <input
                  type="text"
                  placeholder="Dirección"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Salario
                </label>
                <input
                  type="number"
                  placeholder="5000000.00"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <div className="mb-3 block text-black dark:text-white">
                <DatePickerOne label="Fecha de ingreso"/>
                <DatePickerOne label="Fecha de nacimiento"/>
              </div>

              <div className="mb4">
                  <label className="mb-2.5 block font-medium text-black dark:text-white">
                    Tipo De Documento
                  </label>
                  <div className="relative">
                    <select
                      name=""
                      className="w-full rounded-lg border border-stroke bg-transparent py-4 pl-6 pr-10 text-black outline-none focus:border-primary focus-visible:shadow-none dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                    >
                      <option selected disabled>
                        Seleccione una opción
                      </option>
                      <option value="1">Cédula Ciudadanía (C.C)</option>
                      <option value="2">Cédula Extranjería (C.E)</option>
                      <option value="3">Pasaporte (P.A)</option>
                    </select>
                  </div>
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

              <div>
                <label className="mb-3 block text-black dark:text-white">
                  Teléfono
                </label>
                <input
                  type="text"
                  placeholder="Teléfono"
                  className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                />
              </div>

              <button className="inline-flex items-center mx-auto justify-center rounded-full  bg-meta-3 py-4 px-10 text-center font-medium text-white hover:bg-opacity-90 lg:px-8 xl:px-10">
                  Registrar 
                </button>
              
            </div>
          </div>
          
        </div>

      </div>
    </DefaultLayout>
  );
};

export default EmployeeRegistration;
