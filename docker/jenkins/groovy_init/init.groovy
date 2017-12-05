import hudson.model.*
import jenkins.model.*

def e = { filepath ->
  def env = System.getenv()
  evaluate(new File(env["JENKINS_HOME"] + '/init.groovy.d/' + filepath))
}
def admin_email = e("./../config/AdminEmail.groovy")
def agent_port = e("./../config/AgentPort.groovy")
def chmod = e("./../config/Chmod.groovy")
def csrf = e("./../config/Csrf.groovy")
def extended_email = e("./../config/ExtendedEmail.groovy")
def envvars = e("./../config/Envvars.groovy")
def num_executors = e("./../config/NumExecutors.groovy")
def git = e("./../config/Git.groovy")
def java = e("./../config/Java.groovy")
def master_slave_security = e("./../config/MasterSlaveSecurity.groovy")
def matrix_authorization = e("./../config/MatrixAuthorization.groovy")
def maven = e("./../config/Maven.groovy")
def quiet_period = e("./../config/QuietPeriod.groovy")
def user_credential = e("./../config/UserCredentials.groovy")
def env = System.getenv()
def j = Jenkins.getInstance()
def home = env["JENKINS_HOME"]
def creds = '''\
name,global_admin,global_configure_updatecenter,global_read,global_run_scripts,global_upload_plugins,credentials_create,credentials_delete,credentials_manage_domains,credentials_update,credentials_view,agent_build,agent_configure,agent_connect,agent_create,agent_delete,agent_disconnect,job_build,job_cancel,job_configure,job_create,job_delete,job_discover,job_read,job_workspace,run_delete,run_update,view_configure,view_create,view_delete,view_read,scm_tag,metrics_health_check,metrics_thread_dump,metrics_view,job_extendedread,job_move,view_replay
Anonymous,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
authenticated,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0
'''+env["JENKINS_ADMIN_USER"]+''',1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
'''

matrix_authorization(
    instance      = j,
    user_mappings = creds
)
admin_email(
    instance = j,
    admin_addr= env['JENKINS_ADMIN_ADDR']
)
agent_port(
    instance = j,
    port     = env["JENKINS_SLAVE_AGENT_PORT"].toInteger()
)
csrf(
    instance    = j,
    enable_csrf = true
)
extended_email(
    instance = j
)
envvars(
    instance    = j,
    env_var_map = [ "LANG": "en_US.UTF-8" ]
)
num_executors(
    instance      = j,
    num = env["JENKINS_EXECUTORS"].toInteger()
)
git(
    instance = j,
    name  = env['JENKINS_GIT_NAME'],
    email = env['JENKINS_GIT_EMAIL']
)
java(
    instance  = j,
    java_name = "Java",
    java_home = "/usr/lib/jvm/default-jvm"
)
maven(
    instance   = j,
    maven_home = '$MAVEN_HOME',
    maven_opts = '-Xmx1024m'
)
quiet_period(
    instance = j,
    period   = env["JENKINS_QUIET_PERIOD"].toInteger()
)
user_credential(
    instance = j,
    username = env["JENKINS_ADMIN_USER"],
    password = env["JENKINS_ADMIN_PASS"]
)
j.save()
