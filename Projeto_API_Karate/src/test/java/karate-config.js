function fn() {    
  var env = karate.env; // get system property 'karate.env'
  var config = { env: env }
  var headers = {"cache-control": "no-cache"}
  if (!env) { env = 'dev'; }

  switch(env) {
    case 'prod':
      break;
    case 'dev':
      config = karate.read('classpath:services/support/config/path.yaml')['dev']
      break;
    default:

  }

  karate.log('karate.env system property was:', env);
  karate.configure('headers', headers);
  karate.configure('retry', { count: 10, interval: 5000 });
  return config;
}