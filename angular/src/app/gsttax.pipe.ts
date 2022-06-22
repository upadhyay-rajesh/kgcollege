import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'gsttax'
})
export class GsttaxPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
