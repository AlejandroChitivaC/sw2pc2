import React, { useState } from 'react';
import Breadcrumb from '../../components/Breadcrumbs/Breadcrumb';
import DefaultLayout from '../../layout/DefaultLayout';
import DatePickerOne from '../../components/Forms/DatePicker/DatePickerOne';
import SelectGroupOne from '../../components/Forms/SelectGroup/SelectGroupOne';
import SelectGroupTwo from '../../components/Forms/SelectGroup/SelectGroupTwo';


const ProjectRegistration = () => {
  const [form, setForm] = useState({
    projectName: '',
    projectDescription: '',
    startDate: '',
    endDate: '',
    budget: '',
    status: '',
  });

 
  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    // Aquí puedes manejar la lógica de envío del formulario, como enviar los datos al backend
    console.log(form);
  };

  const handelChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: e.target.value });
};

  return (
    <DefaultLayout>
      <Breadcrumb pageName="Registre un nuevo Empleado" />

      <div className="container mx-auto">
        <div className=" justify-center items-center gap-9">
          <div className="rounded-md border border-stroke bg-white shadow-default dark:border-strokedark dark:bg-boxdark">
            <div className="border-b border-stroke py-4 px-6.5 dark:border-strokedark">
              <h3 className="font-medium text-black dark:text-white text-center">
                Proyecto
              </h3>
            </div>
            <form onSubmit={handleSubmit}>
              <div className="flex flex-col gap-5.5 p-6.5">
                <div>
                  <label className="mb-3 block text-black dark:text-white">
                    Nombre
                  </label>
                  <input
                    type="text"
                    id="projectName"
                    placeholder="Nombre del proyecto"
                    className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                    value={form.projectName}
                    onChange={handelChange}
                  />
                </div>

                <div>
                  <label className="mb-3 block text-black dark:text-white">
                    Descripción
                  </label>
                  <input
                    type="text"
                    id='projectDescription'
                    placeholder="El proyecto..."
                    className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                    value={form.projectDescription}
                    onChange={handelChange}
                  />
                </div>

                <div className="mb-3 block text-black dark:text-white">
                  <DatePickerOne label="Fecha de inicio" />
                  <DatePickerOne label="Fecha de finalización" />
                </div>

                <div>
                  <label className="mb-3 block text-black dark:text-white">
                    Presupuesto
                  </label>
                  <input
                    type="number"
                    id='budget'
                    placeholder="2500.000.000"
                    className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                    value={form.budget}
                    onChange={handelChange}
                  />
                </div>

                <div className="mb-3 block text-black dark:text-white">
                  <SelectGroupOne labelText="Líder del proyecto" selectPlaceholder="Seleccione el líder"/>
                </div>

                <div className="mb-3 block text-black dark:text-white">
                  <SelectGroupTwo/>
                </div>

                <button className="inline-flex items-center mx-auto justify-center rounded-full  bg-meta-3 py-4 px-10 text-center font-medium text-white hover:bg-opacity-90 lg:px-8 xl:px-10">
                  Registrar
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </DefaultLayout>
  );
};

export default ProjectRegistration;
