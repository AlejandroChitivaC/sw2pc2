import Breadcrumb from '../../components/Breadcrumbs/Breadcrumb';
import DefaultLayout from '../../layout/DefaultLayout';
import DatePickerOne from '../../components/Forms/DatePicker/DatePickerOne';
import SelectGroupOne from '../../components/Forms/SelectGroup/SelectGroupOne';
import SelectGroupTwo from '../../components/Forms/SelectGroup/SelectGroupTwo';
import useProjectRegistrationForm from '../../hooks/useProjectRegistrationForm';


const ProjectRegistration = () => {
  const {
    projectName,
    projectNameError,
    projectDescription,
    projectDescriptionError,
    budget,
    budgetError,
    startDate,
    startDateError,
    endDate,
    endDateError,
    projectStatusError,
    projectLeaderError,
    successMessage,
    errorMessage,
    handleSubmit,
    handelNameChange,
    handelDescriptionChange,
    handelBudgetChange,
    handleStartDateChange,
    handleEndDateChange,
    handleStatusChange,
    handleLeaderChange,
  } = useProjectRegistrationForm();



  return (
      <DefaultLayout>
        <Breadcrumb pageName="Registre un nuevo Proyecto" />

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
                        type="projectName"
                        id="projectName"
                        placeholder="Nombre del proyecto"
                        className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                        value={projectName}
                        onChange={handelNameChange}
                    />
                    {projectNameError && <p className="text-red-500">{projectNameError}</p>}

                  </div>

                  <div>
                    <label className="mb-3 block text-black dark:text-white">
                      Descripción
                    </label>
                    <input
                        type="projectDescription"
                        id='projectDescription'
                        placeholder="El proyecto..."
                        className="w-full rounded-lg border-[1.5px] border-stroke bg-transparent py-3 px-5 text-black outline-none transition focus:border-primary active:border-primary disabled:cursor-default disabled:bg-whiter dark:border-form-strokedark dark:bg-form-input dark:text-white dark:focus:border-primary"
                        value={projectDescription}
                        onChange={handelDescriptionChange}
                    />
                    {projectDescriptionError && <p className="text-red-500">{projectDescriptionError}</p>}
                  </div>

                  <div className="mb-3 block text-black dark:text-white">
                    <DatePickerOne label="Fecha de inicio" value={startDate} onChange={handleStartDateChange}/>
                    {startDateError && <p className="text-red-500">{startDateError}</p>}
                  </div>

                  <div className="mb-3 block text-black dark:text-white">
                    <DatePickerOne label="Fecha de finalización" onChange={handleEndDateChange} value={endDate}/>
                    {endDateError && <p className="text-red-500">{endDateError}</p>}
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
                        value={budget}
                        onChange={handelBudgetChange}
                    />
                    {budgetError && <p className="text-red-500">{budgetError}</p>}
                  </div>

                  <div className="mb-3 block text-black dark:text-white">
                    <SelectGroupOne
                        labelText="Líder del proyecto"
                        selectPlaceholder="Seleccione el líder"
                        onChange={handleLeaderChange}
                    />

                    {projectLeaderError && <p className="text-red-500">{projectLeaderError}</p>}
                  </div>

                  <div className="mb-3 block text-black dark:text-white">
                    <SelectGroupTwo onChange={handleStatusChange}/>
                    {projectStatusError && <p className="text-red-500">{projectStatusError}</p>}
                  </div>

                  <button
                      className="inline-flex items-center mx-auto justify-center rounded-full  bg-meta-3 py-4 px-10 text-center font-medium text-white hover:bg-opacity-90 lg:px-8 xl:px-10">
                    Registrar
                  </button>

                  <div>
                    {successMessage && <p className="text-green-500">{successMessage}</p>}
                    {errorMessage && <p className="text-red-500">{errorMessage}</p>}
                  </div>

                </div>
              </form>
            </div>
          </div>
        </div>
      </DefaultLayout>
  );
};

export default ProjectRegistration;