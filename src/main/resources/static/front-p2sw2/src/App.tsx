import { useEffect, useState } from 'react';
import { Route, Routes, useLocation } from 'react-router-dom';

import Loader from './common/Loader';
import PageTitle from './components/PageTitle';
import SignIn from './pages/Authentication/SignIn';
import SignUp from './pages/Authentication/SignUp';
import Chart from './pages/Chart';
import ProjectRegistration from './pages/Project/ProjectRegistration';
import ProjectUpdate from './pages/Project/ProjectUpdate';
import ProjectProgress from './pages/Project/ProjectProgress';
import EmployeeRegistration from './pages/Employee/EmployeeRegistration';
import EmployeeAssignment from './pages/Employee/EmployeeAssignment';
import EmployeeTimeProject from './pages/Employee/EmployeeTimeProject';
import GenerateReport from './pages/Report/GenerateReport';
import Alerts from './pages/UiElements/Alerts';
import Buttons from './pages/UiElements/Buttons';

function App() {
  const [loading, setLoading] = useState<boolean>(true);
  const { pathname } = useLocation();

  useEffect(() => {
    window.scrollTo(0, 0);
  }, [pathname]);

  useEffect(() => {
    setTimeout(() => setLoading(false), 1000);
  }, []);

  return loading ? (
    <Loader />
  ) : (
    <>
      <Routes>
        <Route
          path="/"
          index
          element={
            <>
              <PageTitle title="Bienvenido" />
              <SignIn />
            </>
          }
        />
        <Route
          path="/auth/signup"
          element={
            <>
              <PageTitle title="Registro" />
              <SignUp />
            </>
          }
        />
        <Route
          path="/registro-proyecto"
          element={
            <>
              <PageTitle title="Registro Proyecto " />
              <ProjectRegistration />
            </>
          }
        />
        <Route
          path="/actualizar-proyecto"
          element={
            <>
              <PageTitle title="Actualización del proyecto" />
              <ProjectUpdate />
            </>
          }
        />
        <Route
          path="/progreso-proyecto"
          element={
            <>
              <PageTitle title="Progreso del proyecto" />
              <ProjectProgress />
            </>
          }
        />
        <Route
          path="/registro-empleados"
          element={
            <>
              <PageTitle title="Registro Empleados " />
              <EmployeeRegistration />
            </>
          }
        />
        <Route
          path="/tiempo-empleados"
          element={
            <>
              <PageTitle title="Tiempo Proyecto " />
              <EmployeeTimeProject />
            </>
          }
        />
        <Route
          path="/asignacion-empleados"
          element={
            <>
              <PageTitle title="Asignación de empleados " />
              <EmployeeAssignment />
            </>
          }
        />
        <Route
          path="/tiempo-empleados"
          element={
            <>
              <PageTitle title="Tiempo Empleados " />
              <EmployeeTimeProject />
            </>
          }
        />

        <Route
          path="/informe"
          element={
            <>
              <PageTitle title="Informes " />
              <GenerateReport />
            </>
          }
        />

        
        <Route
          path="/chart"
          element={
            <>
              <PageTitle title="Basic Chart | BosquePM App " />
              <Chart />
            </>
          }
        />
        <Route
          path="/ui/alerts"
          element={
            <>
              <PageTitle title="Alerts | BosquePM App" />
              <Alerts />
            </>
          }
        />
        <Route
          path="/ui/buttons"
          element={
            <>
              <PageTitle title="Buttons | BosquePM App" />
              <Buttons />
            </>
          }
        />
        <Route
          path="/auth/signin"
          element={
            <>
              <PageTitle title="Login | BosquePM App" />
              <SignIn />
            </>
          }
        />
        <Route
          path="/auth/signup"
          element={
            <>
              <PageTitle title="Registro | BosquePM App" />
              <SignUp />
            </>
          }
        />
      </Routes>
    </>
  );
}

export default App;