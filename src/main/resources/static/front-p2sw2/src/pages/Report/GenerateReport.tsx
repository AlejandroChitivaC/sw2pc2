import Breadcrumb from '../../components/Breadcrumbs/Breadcrumb';
import DefaultLayout from '../../layout/DefaultLayout';

const GenerateReport = () => {
  return (
    <DefaultLayout>
      <Breadcrumb pageName="Informes" />

      <div className="container mx-auto">
        <div className="justify-center items-center gap-9">
          {/* <!-- Contact Form --> */}
          <div className="rounded-sm border border-stroke bg-white shadow-default dark:border-strokedark dark:bg-boxdark">
            <div className="border-b border-stroke py-4 px-6.5 dark:border-strokedark">
              <h3 className="font-medium text-black dark:text-white text-center">
                Informe
              </h3>
            </div>
            <form action="#">
                <div className="flex flex-col gap-5.5 p-7.5">
                    

                    <button className="inline-flex items-center mx-auto justify-center rounded-full  bg-meta-3 py-4 px-10 text-center font-medium text-white hover:bg-opacity-90 lg:px-8 xl:px-10">
                        Generar Reporte
                    </button>
                </div>
            </form>
          </div>
        </div>
      </div>
    </DefaultLayout>
  );
};

export default GenerateReport;
