# skript-expansion
Use Skript variables in any plugin that supports PlaceholderAPI.


## Placeholders
|  Placeholder  |  Usage  |
|  -----------  |  -----  |
|  %skript_\<variable name\>%  |  %skript_test::hey%  |

## Replacements
> Note: Replacements are placeholders that you can use within placeholders.

### Format
```vb
{<replacement>}
# or if you wanted to use this with MvdW plugins for whatever reason
%<replacement>%
```
|  Replacement  |  Usage  |
|  -----------  |  -----  |
|  player's uuid, uuid of player, uuid  |  %skript_test::{uuid}%  |
|  player's name, name of player, player, name  |  %skript_test::{player}%  |
