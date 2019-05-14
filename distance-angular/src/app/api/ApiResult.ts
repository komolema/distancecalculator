import {ApiHeader} from './ApiHeader';
import {ApiBody} from './ApiBody';

export class ApiResult {
  body: ApiBody;
  header: ApiHeader;

  toString1 = () => JSON.stringify(this, null, '  ');
}
