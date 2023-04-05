import { AppError } from '../interfaces/error';

export class AppErrorImpl implements AppError {
  static readonly 401 = new AppErrorImpl(401, true);
  static readonly 403 = new AppErrorImpl(403, true);

  statusCode: number;
  declancher: boolean;

  private constructor(statusCode: number, declancher: boolean) {
    (this.declancher = declancher), (this.statusCode = statusCode);
  }
}